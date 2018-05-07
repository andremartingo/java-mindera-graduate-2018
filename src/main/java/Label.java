public interface Label {

  /**
   * Returns the label at the [x, y] location
   *
   * @param x column index
   * @param y row index
   * @return the label at the specified location
   */
  int get(int y, int x);

  /**
   * Updates the label at the [x, y] location
   *
   * @param x column index
   * @param y row index
   * @param label the new label for the specified location
   */
  void set(int y, int x, int label);

}
