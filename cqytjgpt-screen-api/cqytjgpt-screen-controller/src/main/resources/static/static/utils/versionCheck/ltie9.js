var version = browV();
if(version.lte9){
    window.location.href = '/' + window.location.pathname.split('/')[1] + '/pages/error/incomepatible.html';
}