package de.hsbi.lockgame.model;

import java.util.List;
import java.util.Objects;

public final class Level {
  private final int width;
  private final int height;
  private final CellType[][] cells;
  private final List<Pin> pins;
  private final Position snakeStart;

  public Level(int width, int height, CellType[][] cells, List<Pin> pins, Position snakeStart) {
    this.width = width;
    this.height = height;
    this.cells = cells;
    this.pins = pins;
    this.snakeStart = snakeStart;
  }

  public boolean isInside(Position pos) {
    return pos.x() >= 0 && pos.x() < width && pos.y() >= 0 && pos.y() < height;
  }

  public CellType cellAt(Position pos) {
    return cells[pos.x()][pos.y()];
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

  public CellType[][] cells() {
    return cells;
  }

  public List<Pin> pins() {
    return pins;
  }

  public Position snakeStart() {
    return snakeStart;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Level) obj;
    return this.width == that.width
        && this.height == that.height
        && Objects.equals(this.cells, that.cells)
        && Objects.equals(this.pins, that.pins)
        && Objects.equals(this.snakeStart, that.snakeStart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height, cells, pins, snakeStart);
  }
}
