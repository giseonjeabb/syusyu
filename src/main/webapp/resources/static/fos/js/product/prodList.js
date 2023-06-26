window.onload = function() {
    const menuItems = document.querySelectorAll('.aside_menu_item');

    menuItems.forEach(item => {
        item.addEventListener('click', (event) => {
            event.preventDefault();
            const submenu = item.parentElement.querySelector('.aside_submenu');
            menuItems.forEach(menuItem => {
                const otherSubmenu = menuItem.parentElement.querySelector('.aside_submenu');
                if (menuItem !== item) {
                    menuItem.classList.remove('active');
                    if (otherSubmenu) {
                        otherSubmenu.classList.remove('active');
                    }
                }
            });
            item.classList.toggle('active');
            if (submenu) {
                submenu.classList.toggle('active');
            }
        });
    });
};