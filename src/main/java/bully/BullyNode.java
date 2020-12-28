package bully;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class BullyNode implements Node {
    private List<PeerHandler> peerHandlers;
    private Integer number;
    private AtomicReference<State> stateAtomicReference = new AtomicReference<>();
    private Integer halt = -1;
    private AtomicBoolean stop = new AtomicBoolean(false);
    private AtomicInteger coordinator = new AtomicInteger(-1);
    private List<PeerHandler> highPriorityHandlers = new ArrayList<>();
    private List<PeerHandler> lowPriorityHandlers = new ArrayList<>();

    public BullyNode(List<PeerHandler> peerHandlers, Integer number) {
        this.peerHandlers = peerHandlers;
        this.number = number;
        this.peerHandlers.sort(Comparator.comparing(PeerHandler::getId));
        this.peerHandlers.forEach(e -> {
            if (e.getId() > getNumber()) {
                this.highPriorityHandlers.add(e);
            } else {
                this.lowPriorityHandlers.add(e);
            }
        });
    }


    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public List<PeerHandler> getPeerHandler() {
        return peerHandlers;
    }

    @Override
    public State getState() {
        return stateAtomicReference.get();
    }

    @Override
    public void start() {
        this.halt = -1;
        coordinator.set(-1);
        stateAtomicReference.set(State.ELECTION);
        election();

    }

    @Override
    public void election() {
        //step-1
        if (this.highPriorityHandlers.stream().anyMatch(e -> {
            try {
                return e.getState() != State.DOWN;

            } catch (TimeoutException ex) {
                ex.printStackTrace();
            }
            return false;
        })) {
            return;
        }

        //step-2
        this.stateAtomicReference.set(State.ELECTION);
        this.halt = this.getNumber();
        List<PeerHandler> up = new ArrayList<>();
        this.getPeerHandler().forEach(e -> {
            try {
                if (e.halt()) {
                    up.add(e);
                }
            } catch (TimeoutException ex) {
                ex.printStackTrace();
            }
        });
        //step-3
        //election point
        this.stateAtomicReference.set(State.REORGANIZATION);
        this.coordinator.set(number);
        if (!up.stream().allMatch(e -> {
            try {
                return e.newCoordinator();
            } catch (TimeoutException ex) {
                return false;
            }
        })) {
            election();
            return;
        }
        //step-4
        if (!up.stream().allMatch(e -> {
            try {
                return e.ready();
            } catch (TimeoutException ex) {
                return false;
            }
        })) {
            election();
            return;
        }
        this.stateAtomicReference.set(State.NORMAL);
    }


}
