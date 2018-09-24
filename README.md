# Share App Cordova Plugin

Allows you to share your cordova app's .apk file via bluetooth.

It looks for the current app's apk file, renames it to the name provided and then sends it via bluetooth to another phone.

It's useful in places where access to internet is limited. Originally created for the Emoyeni app which works completely offline.

Link to [React Native version here](https://github.com/Nicolaidavies/react-native-bluetooth-app-share)

## API

```js
// Using cordova
window.cordova.plugins.shareapp.share(string: fileName)

// Using Ionic 
window['cordova'].plugins.shareapp.share(string: fileName)
```

Note `fileName` is required.



## Example

```js
// Using cordova
window.cordova.plugins.shareapp.share("MyApp")

// Using Ionic 
window['cordova'].plugins.shareapp.share("MyApp")
```