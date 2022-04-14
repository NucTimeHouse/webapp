function getSharePhotos(e){
    var deleteid=e.dataset.deleted;
    var aid = e.dataset.aid;
    var userId=e.dataset.userId;
    $.ajax({
        url:"photo/share/photos",
        type:"GET",
        dataType:"JSON",
        data:{
            deleted: deleteid,
            aid:aid,
            userId:userId
        },
        success:(res)=>{
            sphoto.sPhotosData = res
        }
    })
}

getSharePhotos();

var sphoto = new Vue({
    el: "#sharePhotosGroup",
    data: {
        sPhotosData: []
    }
});