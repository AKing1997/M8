import 'package:flutter/material.dart';
import 'package:nasa/Desktop/EscritorioLayout.dart';
import 'package:nasa/mobile/MovilLayout.dart';
num numMovil = 500;
num numTablet = 1100;
//num numEscritorio = 500;
class Responsibe extends StatelessWidget{
  final Widget movil;
  final Widget tablet;
  final Widget escritorio;
  
  Responsibe({
    required this.movil,
    required this.tablet,
    required this.escritorio,
  });


  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints){
      if(constraints.maxWidth < numMovil){
        return movil;
      }else if(constraints.maxWidth < numTablet){
        return tablet;
      }else{
        return escritorio;
      }
    });
  }

}

