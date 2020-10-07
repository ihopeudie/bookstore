jQuery(function () {
  jQuery.post('http://localhost:8080/book/create?title="title1"', (result) => {
    console.log(result);
  })
})

