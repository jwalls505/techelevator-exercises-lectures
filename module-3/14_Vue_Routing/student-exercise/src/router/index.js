import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home';
import MyBooks from '@/views/MyBooks';
import NewBook from '@/views/NewBook';
import BookDetail from '@/views/BookDetail'


Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'myBooks',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'addBook',
    component: NewBook
  },
  {
    path: '/book/:isbn',
    name: 'Book',
    component: BookDetail
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
