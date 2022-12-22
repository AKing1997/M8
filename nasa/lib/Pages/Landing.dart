// import 'package:flutter/material.dart';
// import 'main.dart';

// var nombre = "Nasa | Pagina Principal";

// class Landig extends State<Ventana> {
//   Widget build(BuildContext context) {
//     var font = TextStyle(
//       fontSize: 18,
//       color: Colors.white,
//       fontWeight: FontWeight.w400
//     );
//     var textos = Theme.of(context).textTheme.headline5;
//     var backgroundColor = Theme.of(context).backgroundColor;
//     return MaterialApp(
//       title: nombre,
//       home: Scaffold(
//         appBar: AppBar(
//             shadowColor: Colors.black,
//             backgroundColor: Color.fromRGBO(10, 6, 85, .5),
//             elevation: 0,
//             toolbarHeight: 70,
//             titleSpacing: 100,
//             title: const Text(
//               "Nasa",
//               style: TextStyle(
//                 fontSize: 50.0,
//                 color: Color.fromRGBO(10, 6, 85, 1),
//                 fontWeight: FontWeight.w800,
//                 fontFamily: 'Roboto',
//                 letterSpacing: 0.5,
//                 height: 1,
//               ),
//             ),

//             actions: <Widget>[

//               TextButton(onPressed: () {}, child: Text("Dia",style: font) ),
//               TextButton(onPressed: () {}, child: Text("Lista",style: font)),
//               TextButton(onPressed: () {}, child: Text("Favorito",style: font),onHover: (valor){

//               }),
//               SizedBox(
//                 width: 100,
//               )
//             ]),
//         body: Center(
//           child: Column(
//             crossAxisAlignment: CrossAxisAlignment.stretch,
//             children: <Widget>[
//               Row(
//                children: <Widget>[
                 
//                  Container(
//                    color: Colors.red,
//                    width: 100,
//                    height: 100,
//                  ),
//                ],
//               ),
//             ],
//           ),
//         ),
//       ),
//     );
//   }
// }
