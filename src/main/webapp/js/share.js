var url=window.location


const getQuery = (url) => {
    // str为？之后的参数部分字符串
    const str = url.substr(url.indexOf('?') + 1)
    // arr每个元素都是完整的参数键值
    const arr = str.split('&')
    // result为存储参数键值的集合
    const result = {}
    for (let i = 0; i < arr.length; i++) {
        // item的两个元素分别为参数名和参数值
        const item = arr[i].split('=')
        result[item[0]] = item[1]
    }
    return result[query]
}
function getQueryString(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    };
    return null;
}
function getSharePhotos(){
    // const res = getQuery(url)

    $.ajax({
        url:"photo/share/photos",
        type:"GET",
        dataType:"JSON",
        data:{
            deleted: getQueryString("deleted"),
            aid: getQueryString("aid"),
            userId: getQueryString("userId"),
            token:getQueryString("token")
        },
        success:(res)=>{
            console.log(res)
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
