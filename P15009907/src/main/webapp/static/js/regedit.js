// JavaScript Document 
  var   flag=false;  
  function   DrawImage(ImgD){  
        var   image=new   Image();  
        image.src=ImgD.src;  
        if(image.width>0   &&   image.height>0){  
          flag=true;  
            ImgD.width=image.width;      
            ImgD.height=image.height;  
            ImgD.alt=image.width+"×"+image.height;  
          }  
        }    
  function   mainChange(Value){  
  flag=false;  
  document.all.mainimage.width=10;  
  document.all.mainimage.height=10;  
  document.all.mainimage.alt="";  
  document.all.mainimage.src=Value;  
  document.all.maindiv.style.display='';  
  }  
   