import 'package:flutter/material.dart';
import 'package:nasa/Pages/Login.dart';
import 'Responsibe/element.dart';
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Nasa Web",
      theme: ThemeData(
        primarySwatch: Colors.indigo,
        fontFamily: 'Quicksand',
      ),
    debugShowCheckedModeBanner: false,
      home: dispositivo(),
    );
  }
}
