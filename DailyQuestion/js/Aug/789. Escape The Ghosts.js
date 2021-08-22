var escapeGhosts = function(ghosts, target) {
  const source = [0, 0];
  const distance = manhattanDistance(source, target);
  for (const ghost of ghosts) {
      const ghostDistance = manhattanDistance(ghost, target);
      //不能比幽灵先到失败
      if (ghostDistance <= distance) {
          return false;
      }
  }
  return true;
}
//最短距离=目的地纵坐标差+目的地横坐标差
const manhattanDistance = (point1, point2) => {
  return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
}
