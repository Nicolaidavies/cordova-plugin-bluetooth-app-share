# Share App Cordova Plugin

Allows you to share your cordova app via bluetooth.

## API

```js
// Using cordova
window.cordova.plugins.shareapp.share(string: nameOfApkFile)

// Using Ionic 
window['cordova'].plugins.shareapp.share(string: nameOfApkFile)
```


## Example

```js
// Using cordova
window.cordova.plugins.shareapp.share("MyApp")

// Using Ionic 
window['cordova'].plugins.shareapp.share("MyApp")
```