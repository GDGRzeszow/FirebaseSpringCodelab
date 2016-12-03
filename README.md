#Firebase Admin with Spring codelabs
Welcome to Firebase Admin with Spring codelabs! 
In this codelab, you'll learn how to use the Firebase with server side code
in Java language.

Codelab created by @GDGRzeszow for "Firebase Christmas Codelabs"
and works with Firebase Android codelab which you can find 
__[here](https://codelabs.developers.google.com/codelabs/firebase-android/)__

On __master__ branch you can find code with empty spaces to fill.
On __develop__ branch you can find code prepared to run.
 

##Steps
1. First we need to generate our private key. 
It will allow us to do all operations at database.
To do it login into your Firebase Console and go to your "Project Settings". 
Next open "Service Accounts" and generate new private key. 

![Alt text](/screens/priv_key.jpg?raw=true "Private key generation")

You can rename downloaded file to "google-services.json" and replace 
file in _resources_ folder or copy content and paste into that file.

2. To have "almost working" project we need to change one more thing. Open _application.yml_ and insert database url. You can find it by clicking
 "Database" in Firebase Console.
 
3. Now we have to initialize our FirebaseService. To do it open _Application_ 
and add line. This will start service after app start. 
```
  context.getBean(FirebaseService.class).startFirebaseListener();
```

4. At this moment we are listening for all changes in _messages_ node.
It's time to do something with it! Open class _FirebaseServiceImpl_.
In method _onDataChange_ same as in Android we get DataSnapshots.
Our proposition is to do it in this way:
```
Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
StreamSupport.stream(iterable.spliterator(), false)
        .forEach(data -> {
            FriendlyMessage friendlyMessage = data.getValue(FriendlyMessage.class);
            final String text = friendlyMessage.getText();
            final String censored = censorService.censorWord(text);
            if (!text.equals(censored)) {
                friendlyMessage.setText(censored);
                data.getRef().setValue(friendlyMessage);
            }
        });
```
With this code we check every message using _CensorService_.
So let's modify what we are checking.

5. In _CensorServiceImpl_ you will find two empty spaces.
At first TODO you can define which words you want to looking for. 
Put them as Strings in Arrays.asList(). 

```
final List<String> badWords =
        Arrays.asList("veryBadWord","anotherOne");
```

To have some fun with censoring we have to implement it in _censorWord_ method.
For example we can replace all occurrences of defines words with using
simple _replaceAll_ method. To do it we have prepared _Pattern_ object.
```
text = text.replaceAll(pattern.pattern(), "***");
```

Now run your android app and try to type some censored word.
It will be changed to stars! 

![Alt text](/screens/app_scr.jpg?raw=true "Private key generation")

