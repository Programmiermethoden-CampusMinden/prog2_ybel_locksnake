package de.hsbi.lockgame.logic;

import de.hsbi.lockgame.model.*;
import java.util.List;
import java.util.Objects;

public final class GameState {
  private final Level level;
  private final Snake snake;
  private final List<Pin> pins;
  private final Status status;
  private final Direction pendingDirection;

  public GameState(
      Level level, Snake snake, List<Pin> pins, Status status, Direction pendingDirection) {
    this.level = level;
    this.snake = snake;
    this.pins = pins;
    this.status = status;
    this.pendingDirection = pendingDirection;
  }

  public Level level() {
    return level;
  }

  public Snake snake() {
    return snake;
  }

  public List<Pin> pins() {
    return pins;
  }

  public Status status() {
    return status;
  }

  public Direction pendingDirection() {
    return pendingDirection;
  }

  public static GameState initial(Level level) {
    var snake = new Snake(List.of(level.snakeStart()));
    return new GameState(level, snake, level.pins(), Status.RUNNING, Direction.NONE);
  }

  public GameState withPendingDirection(Direction d) {
    return new GameState(level, snake, pins, status, d);
  }

  public GameState tick() {
    // TODO: diese Methode lässt das Spiel einen Schritt laufen (berechnet den Spielzustand im
    // nächsten Schritt)

    // TODO: early exit: wenn das Spiel nicht läuft oder keine Blickrichtung gesetzt ist: keine
    // Änderung

    // TODO: prüfe die folgenden Bedingungen:
    // (a) Schlange würde das Spielfeld verlassen: Spiel verloren
    // (b) Schlange würde in ein Wandelement gehen: Blockiert (keine Bewegung, Blickrichtung "none")
    // (c) Schlange beisst sich: Spiel verloren
    // (d) Schlange würde auf einen Pin gehen (Pin bereits gesetzt oder Schlange kommt nicht in der
    // Aktivierungsrichtung): Blockiert (keine Bewegung, Blickrichtung "none")

    // TODO: aktiviere einen noch nicht gesetzten Pin, wenn die Schlange in der richtigen Richtung
    // auf den Pin gehen würde (die Schlange darf dabei aber nicht auf den Pin gehen)

    // TODO: anderenfalls: bewege die Schlange um einen Schritt in Blickrichtung (falls gesetzt)
    throw new UnsupportedOperationException("method not implemented yet");
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (GameState) obj;
    return Objects.equals(this.level, that.level)
        && Objects.equals(this.snake, that.snake)
        && Objects.equals(this.pins, that.pins)
        && Objects.equals(this.status, that.status)
        && Objects.equals(this.pendingDirection, that.pendingDirection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(level, snake, pins, status, pendingDirection);
  }

  public enum Status {
    RUNNING,
    WON,
    LOST_SELF_COLLISION,
    LOST_OUT_OF_BOUNDS;

    public boolean isRunning() {
      return this == RUNNING;
    }
  }
}
