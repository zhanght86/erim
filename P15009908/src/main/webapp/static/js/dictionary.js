//字典
var dictionary = {
    
    //自动补全
    autocomplete : function(id,gqid){
        $("#"+id).focus().autocomplete('/dictionary/list/contry', {
             dataType: "json", //json类型
             delay:10,//延迟10秒  
             max:10,//最多5条记录  
             minChars:1,   
             matchSubset:1,  
             cacheLength:10,  
             matchContains: true,
             parse: function(data) {
                 return $.map(data, function(row) {
                     return {
                         data: row,
                         value: row.codeKey,
                         result: row.codeValue
                     };
                 });
             },
             formatItem: function(item) {
                 return item.codeValue;
             }
         }).result(function(event, data, formatted){  
        	 $("#"+gqid).attr("src", '/static' + data.codeMark);
         });
    }  
};