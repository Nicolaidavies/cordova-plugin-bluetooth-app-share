# Share App Cordova Plugin

Allows you to share your cordova app via bluetooth. 


It looks for the current app's apk file, renames it to the name provided and then sends it via bluetooth to another phone.  

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