
$(document).ready(function() {
    
    $('#dropdown').hover(
        function() {
            $('#dropdownItem').delay(50).slideDown(100);
        },
        function() {
            $('#dropdownItem').slideUp(200);
        }
    );

    $('.searchDropdown').hover(
        function() {
            $('.dropdownSearchBar').delay(50).slideDown(100);
        },
        function() {
            $('.dropdownSearchBar').slideUp(200);
        }
    );

});
