from pyknow import *
from random import choice

class Ground(Fact):
    pass

class Drools(KnowledgeEngine):

    @Rule(Ground(ph=P(lambda ph: ph == 7.2)))
    def ask_ph(self):
        print("==> ph: ALCALINO")
    
    @Rule(AND(Ground(ph=P(lambda ph: ph > 6.8) & P(lambda ph: ph < 7.2))))
    def ask_cd(self):
        print("==> ph: LIGERAMENTE ALCALINO")
    
    #A better way
    def ask_gt(self):
        print("==> ph: NEUTRO")

engine = Drools()
engine.reset()
engine.declare(Ground(ph=choice([6.9, 7.2, 7.2, 7.2])))
engine.run()

