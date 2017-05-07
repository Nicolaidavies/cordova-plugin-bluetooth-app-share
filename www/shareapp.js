var exec = require('cordova/exec');

exports.share = function(arg0, success, error) {
  exec(success, error, "shareapp", "share", [arg0]);
};
