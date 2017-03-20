SeguroCanguro.service('vSeguroCanguroService', function($resource, vSeguroCanguroConstants){

  var that = this;
  this.getListRequest = function(){
    listResource = $resource(vSeguroCanguroConstants.BACKEND_SERVICE_URL,{},
      {
        fetchData:
        {
          method:'GET',
          isArray:true
        }
      });

      return listResource
  }

  return that;
});
