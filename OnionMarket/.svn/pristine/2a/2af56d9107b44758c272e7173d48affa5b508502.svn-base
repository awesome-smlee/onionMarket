$(function () {

    // modal open
    $('[modal-id]').click(modal);

    // modal close
    $('.modal .close-btn').click(function () {
        $(this).parents('.modal').removeClass('open');
        $('html').removeClass('scroll-hidden');
    });

});

function modal() {
    let id = $(this).attr('modal-id');
    $('.modal').removeClass('open').filter('#' + id).addClass('open');
    $('html').addClass('scroll-hidden');
}

