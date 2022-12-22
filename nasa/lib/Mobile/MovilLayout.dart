import 'package:flutter/material.dart';
import 'package:nasa/Responsibe/element.dart';

double ancho = porcentageW(getWidth(), 100);
double alto = porcentageH(getHeight(), 100);
double anchoImg = porcentageWM(getWidth(), 100, intToDouble(250));
double altoImg = porcentageHM(getHeight(), 100, intToDouble(250));

class MovilLayout extends StatefulWidget {
  const MovilLayout({Key? key}) : super(key: key);

  State<MovilLayout> createState() => Movil();
}

class Movil extends State<MovilLayout> {
  @override
  Widget build(BuildContext context) {
  setWidth(MediaQuery.of(context).size.width);
  setHeight(MediaQuery.of(context).size.height);
  bool _isObscure = true;
  final _formKey = GlobalKey<FormState>();
    return Scaffold(
      body: Center(
        child: Column(
          children: [
            Container(
              padding: EdgeInsets.all(25),
              width: ancho,
              height: alto,
              color: loginBC(),
              child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              imagenLogin(anchoImg,altoImg),
              SizedBox(height: 30),
              Form(
                key: _formKey,
                child: Column(
                  children: <Widget>[
                    TextFormField(
                      decoration: const InputDecoration(
                        enabledBorder: UnderlineInputBorder(
                          borderSide: BorderSide(
                            width: 0,
                            color: Colors.white,
                          ),
                        ),
                        labelText: 'Usuario',
                        labelStyle: TextStyle(color: Colors.white),
                        contentPadding: EdgeInsets.only(left: 5),
                        hintStyle: TextStyle(color: Colors.white),
                      ),
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return 'Please enter some text';
                        }
                        return null;
                      },
                    ),
                    espacio(2),
                    TextField(
                      obscureText: _isObscure,
                      decoration: InputDecoration(
                        labelText: 'Contraseña',
                        /**Input decoreacion con estilos y colores */
                        enabledBorder: UnderlineInputBorder(
                          borderSide: BorderSide(
                            width: 0,
                            color: Colors.white,
                          ),
                        ),
                        labelStyle:
                        TextStyle(color: Colors.white), //Estilos de label
                        contentPadding: EdgeInsets.only(left: 5), //Padding
                        hintStyle: TextStyle(color: Colors.white),

                        /** Boton de visibilida de  */
                        suffixIcon: IconButton(
                          icon: Icon(
                            _isObscure
                                ? Icons.visibility
                                : Icons.visibility_off,
                          ),
                          onPressed: () {
                            // setState(() {
                            //   _isObscure = !_isObscure;
                            // });
                          },
                          color: Colors.white,
                        ),
                      ),
                      style: textWN(15),
                    ),
                    espacio(10),
                    ElevatedButton(
                      style: ElevatedButton.styleFrom(
                          minimumSize: const Size.fromHeight(50),
                          // textStyle: Theme.of(context).textTheme.headline6,
                          backgroundColor: Color.fromRGBO(255, 255, 255, 0.3)),
                      onPressed: () {
                        // Validate returns true if the form is valid, or false otherwise.
                        if (_formKey.currentState!.validate()) {
                          // If the form is valid, display a snackbar. In the real world,
                          // you'd often call a server or save the information in a database.
                          // ScaffoldMessenger.of(context).showSnackBar(
                          //   const SnackBar(content: Text('Processing Data')),
                          // );
                        }
                      },
                      child: const Text('Entrar', style: TextStyle(color: Colors.white,fontFamily: 'Roboto')),
                    ),
                  ],
                ),
              ),
            ],
          ),
        
            ),
          ],
        ),
      ),
    );
  }

}

// class Login extends StatelessWidget {
//   const Login({
//     Key? key,
//     required this.anchoLogin,
//     required this.altoLogin,
//     required this.anchoLoginImg,
//     required this.altoLoginImg,
//   }) : super(key: key);
//   final double anchoLogin;
//   final double altoLogin;
//   final double anchoLoginImg;
//   final double altoLoginImg;
//   @override
//   Widget build(BuildContext context) {
//     final screenWidth = MediaQuery.of(context).size.width;
//     screenHeight = MediaQuery.of(context).size.height;
//     return Column(
//       children: [
//         Container(
//           width: 400,
//           height: 300,
//           color: loginBC(),
//           child: Text("data"),
//         ),
//       ],
//     );
//   }
// }
