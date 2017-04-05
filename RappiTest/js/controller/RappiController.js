angular.module('RappiTest').controller('RappiController',function($scope){

  var that  = this;
  this.testCases = 0;
  this.T  = {'testCases':[]};
  this.N = [];
  this.M = [];
  this.output = [];
  this.threeDMatrix = [];

  this.solve = function(){
    that.output = [];
    var i = 0;
    var j = 0;

    for(i = 0; i < this.testCases; i++){
      var matrix = that.threeDMatrix[i];
      var movement = that.M[i];

      for(j = 0; j < movement.length; j++){
        var input = movement[j].input;
        if(movement[j].type === 'QUERY'){
          var value = that.query(i, input[0] - 1 , input[1] - 1, input[2] - 1, input[3] - 1, input[4] - 1, input[5] - 1);
          that.output.push('t_'+i+'m_'+j+': '+movement[j].type+' '+input+'\n'+value);
        }
        else if(movement[j].type === 'UPDATE'){
          that.update(i, input[0] - 1, input[1] - 1, input[2] - 1, input[3]);
        }

      }

    }

  };

  /**Method that validates the inputed value
   * @param testCaseNumber test case number >= 0
   * @param movementNumber movement number >= 0
  */
  this.validateMovement = function(testCaseNumber, movementNumber){
    var movement = that.M[testCaseNumber][movementNumber].movement.split(' ');
    var i =1;
    var checkedInput = 0;
    that.M[testCaseNumber][movementNumber].input = [];
    that.M[testCaseNumber][movementNumber].type = movement[0];

    if(movement[0] === 'UPDATE' && movement.length === 5){

      for(i = 1; i < movement.length; i++){
        checkedInput = parseInt(movement[i]);
        var test1 = angular.isNumber(checkedInput);

        if(i !== 4 && angular.isNumber(checkedInput) &&  checkedInput > 0 && checkedInput <= that.N[testCaseNumber]){
          that.M[testCaseNumber][movementNumber].input.push(checkedInput);
        }
        else if(i === 4 && angular.isNumber(checkedInput) &&  checkedInput >= -Math.pow(10, 9) && checkedInput <= Math.pow(10, 9)){
          that.M[testCaseNumber][movementNumber].input.push(checkedInput);
        }
        else{
          that.M[testCaseNumber][movementNumber].isValid = false;
          return false;
        }
      }

      that.M[testCaseNumber][movementNumber].isValid = true;
      return true;
    }
    else if(movement[0] === 'QUERY' && movement.length === 7){
      for(i = 1; i < movement.length; i++){
        checkedInput = parseInt(movement[i]);
        if(angular.isNumber(checkedInput) && checkedInput > 0 && checkedInput <= that.N[testCaseNumber]){
          that.M[testCaseNumber][movementNumber].input.push(checkedInput);
        }
        else{
          that.M[testCaseNumber][movementNumber].isValid = false;
          return false;
        }
      }

      if(that.M[testCaseNumber][movementNumber].input[0] <= that.M[testCaseNumber][movementNumber].input[3] &&
        that.M[testCaseNumber][movementNumber].input[1] <= that.M[testCaseNumber][movementNumber].input[4] &&
        that.M[testCaseNumber][movementNumber].input[2] <= that.M[testCaseNumber][movementNumber].input[5]){
        that.M[testCaseNumber][movementNumber].isValid = true;
        return true;
      }
      else{
        that.M[testCaseNumber][movementNumber].isValid = false;
        return false;
      }
    }
    else{
      that.M[testCaseNumber][movementNumber].isValid = false;
      return false;
    }
  };

  /*Method that calculates the objects that contain the testCases after
  user input*
  */
  this.calculateTestCases = function(){
    this.T  = {'testCases':[]};
    that.M = new Array(that.testCases);
    that.N = new Array(that.testCases);
    this.threeDMatrix = new Array(that.testCases);

    var i;

    for(i = 0; i < that.testCases; i++){
      that.T.testCases.push({'isValid':true});
    }
  };

  this.validateT = function($index){
    var testCase = that.T.testCases[$index].value.split(' ');

    if(testCase.length !== 2){
      that.T.testCases[$index].isValid = false;
//      $scope.form['T_'+$index].$setValidity(false);
    }
    else if(angular.isNumber(testCase[0]) && testCase[0] >= 1 && testCase[0] <= 100){
      that.T.testCases[$index].isValid = false;
//      $scope.form['T_'+$index].$setValidity(false);
    }
    else if(angular.isNumber(testCase[1]) && testCase[1] >= 1 && testCase[1] <= 1000){
      if(that.T.testCases['testCase'+$index] === undefined){

      }
      else{
        that.T.testCases['testCase'+$index].isValid = false;
      }
//      $scope.form['T_'+$index].$setValidity(false);
    }
    else{
      that.T.testCases[$index].isValid = true;
      that.N[$index] = parseInt(testCase[0]);
      that.M[$index] = [];
      var i = 0;

      for(i = 0; i < parseInt(testCase[1]); i++){
        that.M[$index].push({'movement':'', 'isValid':true});
      }

      that.threeDMatrix[$index] = that.instantiate(that.N[$index]);


//      $scope.form['T_'+$index].$setValidity(true);
    }
  };

  this.getTestCaseMoves = function($parentIndex){
    return that.M['testCase'+$parentIndex];
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

    var threeDMatrix = [];

    for(i = 0; i < n ; i++){
      threeDMatrix.push([]);

      for(j = 0; j < n ; j++){
        threeDMatrix[i].push([]);

        for(k = 0; k < n ; k++){
          threeDMatrix[i][j].push([]);

          threeDMatrix[i][j][k] = 0;
        }
      }
    }

    return threeDMatrix;
  };

  this.update = function(testCase, x, y, z, value){
    that.threeDMatrix[testCase][x][y][z] = value;
  };

  this.query = function(testCase, startX, startY, startZ, endX, endY, endZ){

    var sum = 0;

    var i = startX;
    var j = startY;
    var k = startZ;

    for(i = startX; i <= endX; i++){
      for(j = startY; j <= endY; j++){
        for(k = startZ; k <= endZ; k++){
          sum += that.threeDMatrix[testCase][i][j][k];
        }
      }
    }

    return sum;


  };

});
