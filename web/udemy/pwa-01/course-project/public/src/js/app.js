var deferredPrompt;

if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('/sw.js').then(() => {
    console.log('Service worker registered!');
  });
}

window.addEventListener('beforeinstallprompt', event => {
  console.log('beforeinstallprompt fired');
  event.preventDefault();
  deferredPrompt = event;
  return false;
});

var promise = new Promise((resolve, reject) => {
  setTimeout(() => {
    //resolve('This is executed once the timer is done');
    reject({
      code: 500,
      message: 'An error occurred!',
    });
    // console.log('This is executed once the timer is done');
  }, 3000);
});

promise
  .then(text => {
    return text;
  })
  .then(newText => {
    console.log(newText);
  })
  .catch(err => {
    console.log(err.code, err.message);
  });

console.log('This is executed right after setTimeout()');
