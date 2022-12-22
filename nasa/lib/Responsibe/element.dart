import 'package:flutter/material.dart';
import 'package:nasa/Desktop/EscritorioLayout.dart';
import 'package:nasa/mobile/MovilLayout.dart';
import 'package:nasa/responsibe/Responsibe.dart';
import 'package:nasa/tablet/TabletLayout.dart';

BuildContext context = context;

double screenWidth = 0;
double screenHeight = 0;

double intToDouble(numero) {
  double numD = numero.toDouble();
  return numD;
}

Color loginBC(){
  return Color.fromRGBO(10, 6, 85, 1);
}



SizedBox espacio(porcentaje){
    return SizedBox(height: porcentageH(getHeight(), intToDouble(porcentaje)));
}


Image imagenLogin(ancho, alto){
  double anch = ancho.toDouble();
  double alt= alto.toDouble();
  return Image.asset('img/nasa_icon.png',width: anch, height: alt,);
}

double width =0;
double height=0;

setWidth(numero){width=numero;}
setHeight(numero){height=numero;}
double getWidth(){return width;}
double getHeight(){return height;}

TextStyle textWN(tamano) {
  return TextStyle(
    fontSize: intToDouble(tamano),
    fontFamily: 'Roboto',
    fontWeight: FontWeight.normal,
    color: Colors.white,
  );
}

TextStyle textDWN(tamano) {
  return TextStyle(
    fontSize: tamano,
    fontFamily: 'Roboto',
    fontWeight: FontWeight.normal,
    color: Colors.white,
  );
}

TextStyle textWB(tamano) {
  return TextStyle(
    fontSize: intToDouble(tamano),
    fontFamily: 'Quicksand',
    fontWeight: FontWeight.bold,
    color: Colors.white,
  );
}

/* Devuelve el tipo de dispositivo */
Responsibe dispositivo() {

  return Responsibe(
    movil: const MovilLayout(),
    escritorio: const EscritorioLayout(),
    tablet: const TabletLayout(),
  );


}

String dispositivoS() {
  var dispositivo = "";
  var tipo = Responsibe(
    movil: const MovilLayout(),
    escritorio: const EscritorioLayout(),
    tablet: const TabletLayout(),
  );
    if (tipo=='movil') {
      dispositivo = "movil";
    } else if (tipo=="tablet") {
      dispositivo = "tablet";
    } else {
      dispositivo = "escritorio";
    }
    return dispositivo;
  }

double porcentageW(pantallaW, porcentage) {
  double numD = (pantallaW * (porcentage / 100));
  return numD;
}

double porcentageH(pantallaH, porcentage) {
  double numD = (pantallaH * (porcentage / 100));
  return numD;
}

double porcentageWM(pantallaW, porcentage, maximo) {
  double numD = (pantallaW * (porcentage / 100));
  if(numD>maximo){
    numD=maximo;
  }
  return numD;
}

double porcentageHM(pantallaH, porcentage, maximo) {

  double numD = (pantallaH * (porcentage / 100));
  if(numD>maximo){
    numD=maximo;
  }
  return numD;
}