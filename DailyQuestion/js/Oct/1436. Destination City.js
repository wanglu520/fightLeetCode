/**
 * @param {string[][]} paths
 * @return {string}
 */
//先遍历一次paths，通过map key=当前城市，val=目标城市
 var destCity = function(paths) {
  if(!paths || paths.length === 0) return;
  const map = {};
  for(const path of paths){
      map[path[0]] = path[1];
  }
  let end = paths[0][0];
  while(map[end]){
      end = map[end];
  }
  return end;
};