import Vue from 'vue'
import VueRouter from 'vue-router'
import AddReview from '@/views/AddReview'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'

Vue.use(VueRouter)

const routes = [
  {
    component: Products,
    path: '/',
    name: 'products'
  },
  {
    path: '/products/:id',
    component: ProductDetail,
    name: 'product-detail'
  },
  {
    path: '/products/:id/add-review',
    component: AddReview,
    name: 'add-review'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
