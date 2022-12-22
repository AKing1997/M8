import 'package:flutter/material.dart';
import 'package:nasa/Responsibe/element.dart';
import 'package:nasa/Pages/Login.dart';

double anchoLogin = porcentageWM(screenWidth, 80,intToDouble(450));
double altoLogin = porcentageHM(screenHeight, 80,intToDouble(600));
double anchoLoginImg = 250;
double altoLoginImg = 250;

class EscritorioLayout extends StatefulWidget {
  const EscritorioLayout({Key? key}) : super(key: key);

  State<EscritorioLayout> createState() => Escritorio();
}

class Escritorio extends State<EscritorioLayout> {
  @override
  Widget build(BuildContext context) {
    bool _isObscure = true;
    final _formKey = GlobalKey<FormState>();
    final screenWidth = MediaQuery.of(context).size.width;
    final screenHeight = MediaQuery.of(context).size.height;
    return Scaffold(
      body: Center(
        child: Container(
          padding: EdgeInsets.all(25),
          width: porcentageWM(screenWidth, 80,intToDouble(500)),
          height: porcentageHM(screenHeight, 80,intToDouble(600)),
          color: loginBC(),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                width: porcentageWM(screenWidth, 100,intToDouble(200)),
                height: porcentageHM(screenHeight, 100,intToDouble(200)),
                child: imagenLogin(anchoLoginImg, altoLoginImg),
                //child: Text("Nasa", style: textWB(72)),
              ),
              SizedBox(height: porcentageH(screenHeight, 2)),
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
                    SizedBox(height: porcentageH(screenHeight, 2)),
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
                            setState(() {
                              _isObscure = !_isObscure;
                            });
                          },
                          color: Colors.white,
                        ),
                      ),
                      style: textWN(15),
                    ),
                    SizedBox(height: porcentageH(screenHeight, 5)),
                    ElevatedButton(
                      style: ElevatedButton.styleFrom(
                          minimumSize: const Size.fromHeight(50),
                          textStyle: Theme.of(context).textTheme.headline6,
                          backgroundColor: Color.fromRGBO(255, 255, 255, 0.3)),
                      onPressed: () {
                        // Validate returns true if the form is valid, or false otherwise.
                        if (_formKey.currentState!.validate()) {
                          // If the form is valid, display a snackbar. In the real world,
                          // you'd often call a server or save the information in a database.
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(content: Text('Processing Data')),
                          );
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
      ),
    );
  }

}
