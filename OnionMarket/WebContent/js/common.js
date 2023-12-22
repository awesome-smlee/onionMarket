document.addEventListener("DOMContentLoaded", function () {

    // 로고 클릭시 스크롤 상단으로 이동
    $(".logo").on('click', () => {
        $("html,body").animate({
            scrollTop: 0
        }, 500);
    });

    // scroll-top 애니메이션 이벤트
    // $(window).scroll(function () {
    //     if ($(this).scrollTop() >= "300") {
    //         $(".scroll-top").addClass("fixed");
    //     } else {
    //         $(".scroll-top").removeClass("fixed");
    //     }
    // });
    $(".scroll-top button").click(function () {
        $("html,body").animate({
            scrollTop: 0
        }, 300);
    });


    // 메뉴 gnb 이벤트
    $("header nav .gnb > li").hover(function () {
        $(this).find(".depth2").css({ opacity: 1, top: "80px", visibility: "visible" });
    }, function () {
        $(this).find(".depth2").css({ opacity: 0, top: "100%", visibility: "hidden" });
    });


    // Tab
    const tabContainers = $('.tab-type');

    tabContainers.each(function () {
        const container = $(this);
        const tabButtons = container.find('.tab-btn');
        const tabContents = container.find('.tab-content');
        const tabIndicator = container.find('.tab-indicator');
        const numTabs = tabButtons.length;
        let activeTabIndex = 0;

        function showTab(tabIndex) {
            if (tabIndex === activeTabIndex) {
                return;
            }
            tabButtons.removeClass('active');
            tabContents.removeClass('active');
            tabButtons.eq(tabIndex).addClass('active');
            tabContents.eq(tabIndex).addClass('active');
            activeTabIndex = tabIndex;

            // Move the tab indicator to the active button
            const activeButton = tabButtons.eq(tabIndex);
            const buttonRect = activeButton[0].getBoundingClientRect();
            const tabIndicatorWidth = buttonRect.width;
            const tabIndicatorOffset = buttonRect.left - activeButton.parent()[0].getBoundingClientRect().left;
            tabIndicator.css({ width: `${tabIndicatorWidth}px`, transform: `translateX(${tabIndicatorOffset}px)` });
        }

        tabButtons.each(function (index) {
            $(this).click(function () {
                showTab(index);
            });
        });

        // Initialize the tab indicator position
        showTab(0);
    });

    // 별점
    $(".star-grade label").on("click", function () {
        $(this).parent().addClass("on");
    });

    // 동네 선택 이벤트
    $("#town ul li").on("click", function () {
        $(this).addClass("active").siblings("li").removeClass("active");
    });

    // 카테고리 선택 이벤트
    $("#category ul li").on("click", function () {
        $(this).toggleClass("active");
    });

    // 알람 패널 이벤트
    $("header .alarm-btn").on("click", function () {
        $(".side-panel-area").addClass("open");
    });

	// 알람 패널의 닫기버튼 클릭시 패널 비활성화
    $(".side-panel-area .side-panel-close").on("click", function () {
        $(".side-panel-area").removeClass("open");
    });

});
