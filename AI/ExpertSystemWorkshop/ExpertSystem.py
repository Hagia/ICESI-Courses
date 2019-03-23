from pyknow import *
from random import choice

class Ground(Fact):
    pass

class Drools(KnowledgeEngine):

    @Rule(Ground(ph=P(lambda ph: ph == 7.2)))
    def rule_1(self):
        yield Ground(PH="ALCALINO")
        print("==> ph: ALCALINO")
    
    @Rule(Ground(ph=P(lambda ph: ph > 6.8) & P(lambda ph: ph < 7.2)))
    def rule_2(self):
        yield Ground(PH="LIGERAMENTE ALCALINO")
        print("==> ph: LIGERAMENTE ALCALINO")

    @Rule(Ground(ph=P(lambda ph: ph<=6.8) & P(lambda ph: ph>= 6.2)))
    def rule_3(self):
        yield Ground(PH="NEUTRO")
        print("==> ph: NEUTRO")

    @Rule(Ground(ph=P(lambda ph: ph>5.6) & P(lambda ph: ph<6.2)))
    def rule_4(self):
        yield Ground(PH="LIGERAMENTE ACIDO")
        print("==> ph: LIGERAMENTE ACIDO")

    @Rule(Ground(ph=P(lambda ph: ph <= 5.6)))
    def rule_5(self):
        yield Ground(PH="ACIDO")
        print("==> ph: ACIDO")

    @Rule(Ground(ce=P(lambda ce: ce < 0.8)))
    def rule_6(self):
        yield Ground(CE="BAJA")
        print("==> conductividadElectrica: BAJA")

    @Rule(Ground(ce=P(lambda ce: ce >= 0.8)))
    def rule_7(self):
        yield Ground(CE="ALTA")
        print("==> conductividadElectrica: ALTA")

    @Rule(Ground(PH=L("ALCALINO")))
    def rule_8(self):
        print("\n\n")
        print("==> ExtractoSoluble: True")

    @Rule(Ground(PH=L("LIGERAMENTE ALCALINO")))
    def rule_9(self):
        print("\n\n")
        print("==> ExtractoSoluble: True")

    @Rule(AND(Ground(arcilla=P(lambda arcilla: arcilla >= 40.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_10(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Limitaciones de movimiento de agua")
        print("     |-(2) Baja difusion de Oxigeno y flujo de gases")
        print("     |-(3) Baja mineralizacion de MO (Baja actvidad microbiologica")
        print("     |-(4) Acumulacion de iones alcalinoterreos")

    @Rule(AND(Ground(arena=P(lambda arena: arena >= 50.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_11(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Revisar las mediciones realizadas.")

    @Rule(AND(Ground(limo=P(lambda limo: limo >= 45.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_12(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Revisar las mediciones realizadas.")
        print("     |-(1) Coloraciones grises suelo (Glaizeado)")
        print("     |-(2) Suelo Hidromorfico")   
        print("     |-(3) Limitaciones fisicas temporales")
        print("     |-(4) Baja difusion de Oxigeno y flujo de gases")

    @Rule(AND(Ground(arcilla=P(lambda limo: limo <= 40.0)),
    Ground(arcilla=P(lambda arcilla: arcilla <=40.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_13(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Baja disponibilidad de Fosforo (Precipitación)")
        print("     |-(2) Baja disponibilidad de Calcio");  

    @Rule(AND(Ground(arcilla=P(lambda arcilla: arcilla >=40.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("BAJA"))))
    def rule_14(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Limitaciones de movimiento de agua")
        print("     |-(2) Baja difusion de Oxigeno y flujo de gases")
        print("     |-(3) Baja mineralizacion de MO (Baja actvidad microbiologica")
        print("     |-(4) Acumulacion de iones alcalinoterreos	")
        print("     |-(5) Baja disponibilidad de elementos menores ")

    @Rule(AND(Ground(arena=P(lambda arena: arena >=50.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("BAJA"))))
    def rule_15(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Revisar las mediciones realizadas.")

    @Rule(AND(Ground(limo=P(lambda limo: limo >=45.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("BAJA"))))
    def rule_16(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Coloraciones grises suelo (Glaizeado)")
        print("     |-(2) Suelo Hidromorfico")
        print("     |-(3) Limitaciones fisicas temporales")
        print("     |-(4) Baja difusion de Oxigeno y flujo de gases")
        print("     |-(5) Baja disponibilidad de elementos menores ")

    @Rule(AND(Ground(limo=P(lambda limo: limo <=40.0)),
    Ground(arcilla=P(lambda arcilla: arcilla <=40.0)),
    Ground(PH=L("ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_17(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Baja disponibilidad de Fosforo (Precipitación)")
        print("     |-(2) Baja disponibilidad de Calcio")
        print("     |-(3) Baja disponibilidad de elementos menores ")
    
    @Rule(AND(Ground(arcilla=P(lambda arcilla: arcilla <=40.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_18(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Limitaciones de movimiento de agua")
        print("     |-(2) Baja difusion de Oxigeno y flujo de gases")
        print("     |-(3) Baja mineralizacion de MO (Baja actvidad microbiologica")
        print("     |-(4) Acumulacion de iones alcalinoterreos	")
        print("     |-(5) Alta saturación de calcio")
        print("     |-(6) Salinidad en el suelo")
        print("     |-(7) Baja disponibilidad de Fosforo (Precipitación)")

    @Rule(AND(Ground(arena=P(lambda arena: arena >=50.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_19(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Revisar las mediciones realizadas.")

    @Rule(AND(Ground(limo=P(lambda limo: limo >=45.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_20(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Coloraciones grises suelo (Glaizeado)")
        print("     |-(2) Suelo Hidromorfico")
        print("     |-(3) Limitaciones fisicas temporales")
        print("     |-(4) Baja difusion de Oxigeno y flujo de gases")

    @Rule(AND(Ground(limo=P(lambda limo: limo <=40.0)),
    Ground(arena=P(lambda arena: arena <=40.0)),
    Ground(arcilla=P(lambda arcilla: arcilla <=40.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("ALTA"))))
    def rule_21(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Baja disponibilidad de Fosforo (Precipitación)")
        print("     |-(2) Baja disponibilidad de Calcio")

    @Rule(AND(Ground(arcilla=P(lambda arcilla: arcilla >=40.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("BAJA"))))
    def rule_22(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Limitaciones de movimiento de agua")
        print("     |-(2) Baja difusion de Oxigeno y flujo de gases")   
        print("     |-(3) Baja mineralizacion de MO (Baja actvidad microbiologica")
        print("     |-(4) Acumulacion de iones alcalinoterreos	")
        print("     |-(5) Baja disponibilidad de elementos menores ")

    @Rule(AND(Ground(arena=P(lambda arena: arena >=50.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("BAJA"))))
    def rule_23(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Revisar las mediciones realizadas.")

    @Rule(AND(Ground(limo=P(lambda limo: limo >=45.0)),
    Ground(PH=L("LIGERAMENTE ALCALINO")),
    Ground(CE=L("BAJA"))))
    def rule_24(self):
        print("\n\n")
        print("==>")
        print("     |-(1) Coloraciones grises suelo (Glaizeado)")
        print("     |-(2) Suelo Hidromorfico")
        print("     |-(3) Limitaciones fisicas temporales")
        print("     |-(4) Baja difusion de Oxigeno y flujo de gases")
        print("     |-(5) Baja disponibilidad de elementos menores ")
    
engine = Drools()
engine.reset()
engine.declare(Ground(PH=choice(["ALCALINO"])))
engine.declare(Ground(CE=choice(["ALTA"])))
engine.declare(Ground(arcilla=choice([40.0])))
engine.run()
