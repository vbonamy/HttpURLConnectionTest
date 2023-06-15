Classe JAVA de test de connexion HTTP(S) - GET
============================

Simple classe JAVA faisant un GET sur une URL.

Peut permettre de tester que la connexion à un site en https fonctionne correctement via un GET opéré par une JVM :
pour débuguer des problèmes de configuration SSL, chaîne de certificats, algorithmes de chiffrement, keystore, etc.

## Compilation
``` 
mvn package

```

## Lancement
``` 
java -jar target/HttpUrlConnectionTest-1.0-SNAPSHOT.jar https://www.esup-portail.org
```

## Retour attendu

En cas de 'succès' :
```
juin 15, 2023 10:27:26 AM org.esupportail.httpurltest.HttpURLConnectionTest main
INFOS: Connexion à https://www.esup-portail.org ...
juin 15, 2023 10:27:27 AM org.esupportail.httpurltest.HttpURLConnectionTest main
INFOS: Ouverture de connexion OK
juin 15, 2023 10:27:27 AM org.esupportail.httpurltest.HttpURLConnectionTest main
INFOS: Get OK - code de retour : 200
```

En cas d'erreur :
```
juin 15, 2023 10:28:44 AM org.esupportail.httpurltest.HttpURLConnectionTest main
INFOS: Connexion à https://toto.esup-portail.org ...
juin 15, 2023 10:28:44 AM org.esupportail.httpurltest.HttpURLConnectionTest main
INFOS: Ouverture de connexion OK
juin 15, 2023 10:28:44 AM org.esupportail.httpurltest.HttpURLConnectionTest main
GRAVE: Erreur lors du GET sur l'url https://toto.esup-portail.org
java.net.UnknownHostException: toto.esup-portail.org
	at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:567)
	at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327)
	at java.base/java.net.Socket.connect(Socket.java:633)
	at java.base/sun.security.ssl.SSLSocketImpl.connect(SSLSocketImpl.java:304)
	at java.base/sun.security.ssl.BaseSSLSocketImpl.connect(BaseSSLSocketImpl.java:174)
	at java.base/sun.net.NetworkClient.doConnect(NetworkClient.java:183)
	at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:531)
	at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:636)
	at java.base/sun.net.www.protocol.https.HttpsClient.<init>(HttpsClient.java:266)
	at java.base/sun.net.www.protocol.https.HttpsClient.New(HttpsClient.java:380)
	at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.getNewHttpClient(AbstractDelegateHttpsURLConnection.java:193)
	at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1242)
	at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1128)
	at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:179)
	at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.connect(HttpsURLConnectionImpl.java:142)
	at org.esupportail.httpurltest.HttpURLConnectionTest.main(HttpURLConnectionTest.java:24)
```