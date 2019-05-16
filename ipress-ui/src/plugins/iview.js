import Vue from 'vue'
import router from '../router'
import iView from 'iview'

Vue.use(iView)

router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    next();
});

router.afterEach(() => {
    iView.LoadingBar.finish();
});

import 'iview/dist/styles/iview.css'
