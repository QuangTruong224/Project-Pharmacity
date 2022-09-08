// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080',
  firebaseConfig: {
    apiKey: 'AIzaSyAFIkb0qmJY43dAKphbQSZ778WT_aLNfuo',
    authDomain: 'c1221g1-firebase.firebaseapp.com',
    databaseURL: 'https://c1221g1-firebase-default-rtdb.firebaseio.com',
    projectId: 'c1221g1-firebase',
    storageBucket: 'c1221g1-firebase.appspot.com',
    messagingSenderId: '535591875350',
    appId: '1:535591875350:web:7c310ddb990697c0bbd637',
    measurementId: 'G-CVJD51BD70'
  },
  apiBaseUrl: 'http://localhost:3000',
  url8080retail: 'http://localhost:8080/api/manager-sale/invoiceMedicines',
  url8080prescription: 'http://localhost:8080/api/manager-prescription/prescriptions',
  adminChat: {
    name: 'ADMIN',
    uuid: 'ADMIN-C12'
  }
};

export const config = {
  apiKey: 'AIzaSyAmka5eULManLz7IecrSgJy4LF85j8ptYA',
  authDomain: 'c1221g1-pharmacy.firebaseapp.com',
  projectId: 'c1221g1-pharmacy',
  storageBucket: 'c1221g1-pharmacy.appspot.com',
  messagingSenderId: '286698930676',
  appId: '1:286698930676:web:64331d09dc09f2dc7939a1',
  databaseURL: 'https://c1221g1-pharmacy-default-rtdb.asia-southeast1.firebasedatabase.app',
  measurementId: 'G-904D7C7FF4'
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
