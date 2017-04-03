angular.module('RappiTest').controller('RappiController',function(){

  var that  = this;
  this.testCases = 0;

  this.getTestCases = function(){
    return new Array(that.testCases);
  };

  this.instantiate = function(){
      that.threeDMatrix = [];
      that.threeDMatrix[0] = [];
      that.threeDMatrix[0][0] = [];
  };

  this.updateXYZ = function(x, y, z, value){
    that.threeDMatrix[x][y][z] = value;
  };

  this.query = function(startX, startY, startZ, endX, endY, endZ){

    var sum = 0;

    for(startX; startX -1 < endX; startX++){
      for(startY; startY - 1 < endY; startY++){
        for(startZ; startZ -1 < endZ; startZ++){
          sum += that.threeDMatrix[startX][startY][startZ];
        }
      }
    }

    return;


  };

});
