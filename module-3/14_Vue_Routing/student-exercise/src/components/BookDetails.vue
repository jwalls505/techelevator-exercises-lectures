<template>
  <div>
    {{ book.title }}
    {{ book.author }}
  </div>
</template>

<script>
export default {
  name: "book-details",
  props: {
    book: Object,
  },
};
</script>