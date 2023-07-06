<<<<<<< HEAD
document.getElementById('cate_search_button').addEventListener('click', function() {
    this.classList.add('active');
    document.getElementById('cate_search').classList.add('active');
    document.getElementById('search-box').classList.add('active');
    document.getElementById('form-group').classList.add('hidden');
});

document.getElementById('cate_choice_button').addEventListener('click', function() {
    this.classList.add('active');
    document.getElementById('cate_search').classList.remove('active');
    document.getElementById('search-box').classList.remove('active');
    document.getElementById('search-box').classList.add(' hidden');

    document.getElementById('form-group').classList.remove('hidden');
    document.getElementById('form-group').classList.add('active');
=======
document.getElementById('search-category-button').addEventListener('click', function() {
    this.classList.add('active');
    document.getElementById('select-category-button').classList.remove('active');
    document.getElementById('search-box').classList.remove('hidden');
    document.getElementById('textarea-group').classList.add('hidden');
});

document.getElementById('select-category-button').addEventListener('click', function() {
    this.classList.add('active');
    document.getElementById('search-category-button').classList.remove('active');
    document.getElementById('textarea-group').classList.remove('hidden');
    document.getElementById('search-box').classList.add('hidden');
>>>>>>> soso
});
