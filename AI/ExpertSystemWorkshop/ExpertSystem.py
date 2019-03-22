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

    
engine = Drools()
engine.reset()
engine.declare(Ground(PH=choice(["ALCALINO"])))
engine.declare(Ground(CE=choice(["ALTA"])))
engine.declare(Ground(arcilla=choice([40.0])))
engine.run()

