import 'package:flutter/material.dart';
import 'package:nasa/responsibe/element.dart';

class TabletLayout extends StatefulWidget {
  const TabletLayout({Key? key}) : super(key: key);

  State<TabletLayout> createState() => Tablet();
}

class Tablet extends State<TabletLayout> {
  bool _isObscure = true;
  @override
  Widget build(BuildContext context) {
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
                child: imagenLogin(250,250),
                //child: Text("Nasa", style: textWB(72)),
              ),
              SizedBox(height: porcentageH(screenHeight, 2)),
              Form(
                key: _formKey,
                child: Column(
                  children: <Widget>[
                    TextFormField(
                      cursorColor: Colors.red,
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
                      style: textWN(15),
                    ),
                    SizedBox(height: porcentageH(screenHeight, 2)),
                    TextField(
                      cursorColor: Colors.red,
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
                            //setState(() {});
                              _isObscure = !_isObscure;
                              setState(() {});
                            //});
                          },
                          color: Colors.white,
                        ),
                      ),
                      style: textWN(15),
                    ),
                    SizedBox(height: porcentageH(screenHeight, 5)),
                    Stack(children: [
                      Positioned.fill(
                        child: Container(
                          decoration: const BoxDecoration(
                            gradient: LinearGradient(
                              colors: <Color>[
                                Color(0xFF0DA141),
                                Color(0xFF79D219),
                                Color(0xFFF5B3B3),
                              ],
                            ),
                          ),
                        ),
                      ),
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

                    ],),
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
