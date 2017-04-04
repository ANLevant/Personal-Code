angular.module('RappiTest').controller('RappiController',function($scope){

  var that  = this;
  this.testCases = 0;
  this.T  = {'testCases':[]};
  this.N = 0;
  this.M = {'moves':[]};

  this.calculateTestCases = function(){
    this.T  = {'testCases':[]};

    var i;

    for(i = 0; i < that.testCases; i++){
      that.T.testCases.push({'isValid':true});
    }
  };

  this.validateT = function($index){
    var testCase = that.T.testCases[$index].value.split(' ');

    if(testCase.length !== 2){
      that.T.testCases[$index].isValid = false;
      $scope.form['T_'+$index].$setValidity(false);
    }
    else if(angular.isNumber(testCase[0]) && testCase[0] >= 1 && testCase[0] <= 100){
      that.T.testCases[$index].isValid = false;
      $scope.form['T_'+$index].$setValidity(false);
    }
    else if(angular.isNumber(testCase[1]) && testCase[1] >= 1 && testCase[1] <= 1000){
      that.T.testCases[$index].isValid = false;
      $scope.form['T_'+$index].$setValidity(false);
    }
    else{
      that.T.testCases[$index].isValid = true;
      that.N = parseInt(testCase[0]);

      that.instantiate(that.N);

      $scope.form['T_'+$index].$setValidity(true);
    }
  };

  this.isValid = function(testCase){
    if(testCase.length > 0){
      return $scope['T_'+testCase.index].$validate;
    }
    else{
      return false;
    }
  };

  this.instantiate = function(n){

    var i = 0;
    var j = 0;
    var k = 0;

    that.threeDMatrix = [[[]]];

    for(i = 0; i < n ; i++){
      that.threeDMatrix[''+i]=[];

      for(j = 0; j < n ; j++){
        that.threeDMatrix[i].push([]);

        for(k = 0; i < k ; k++){
          that.threeDMatrix[i][j].push([]);

          that.threeDMatrix[i][j][k] = 0;
        }
      }
    }
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
