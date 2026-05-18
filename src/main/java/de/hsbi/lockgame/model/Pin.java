package de.hsbi.lockgame.model;

import java.util.Objects;

public final class Pin {
  private final Position position;
  private final State state;
  private final Direction activationDirection;

  public Pin(Position position, State state, Direction activationDirection) {
    this.position = position;
    this.state = state;
    this.activationDirection = activationDirection;
  }

  public Pin withState(State newState) {
    return new Pin(position, newState, activationDirection);
  }

  public Position position() {
    return position;
  }

  public State state() {
    return state;
  }

  public Direction activationDirection() {
    return activationDirection;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Pin) obj;
    return Objects.equals(this.position, that.position)
        && Objects.equals(this.state, that.state)
        && Objects.equals(this.activationDirection, that.activationDirection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, state, activationDirection);
  }

  public enum State {
    LOW,
    HIGH;

    public boolean isSet() {
      return this == HIGH;
    }
  }
}
