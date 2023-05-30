<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  $(document).ready(function() {
    $('#filter-form').submit(function(event) {
      event.preventDefault();

      const category = $('#category').val();
      const readTime = $('#readTime').val();

      const url = '/blogs';
      const data = { category: category, readTime: readTime };

      $.get(url, data, function(response) {
        $('#blogList').html(response);
      });
    });
  });
