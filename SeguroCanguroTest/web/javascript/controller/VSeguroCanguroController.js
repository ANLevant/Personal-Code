SeguroCanguro.controller('vSeguroCanguroController', function(vSeguroCanguroService){

  that = this;

  vSeguroCanguroService.getListRequest().fetchData(function(data){
        that.tableData = data;
  });

  this.works = 'yes!!!';
});
