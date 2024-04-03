$(document).ready(function() {
    var currentPath = window.location.pathname; // 현재 페이지의 경로
    $('a[href="'+currentPath+'"]').addClass('active').closest('.collapse').addClass('show').prev().attr('aria-expanded', true).closest('.collapse').addClass('show').prev().attr('aria-expanded', true);
});