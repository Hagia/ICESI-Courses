from pyknow import *

class Ground(Fact):
    pass

class Drools(KnowledgeEngine):

    @Rule(Ground(ph>=7.2))
    def ask_ph(self):
        self.declare(Fact(ph=input("What's is the ground Ph?")))
    @Rule(Ground(ph>6.8 & ph <7.2))
    def ask_cd(self):
        self.declare(Fact(cd=input("What's is the ground electricity condutivity?")))
    
    @Rule(Ground(ph <= 6.8 & ph > 6.2))
    def ask_gt(self):
        self.declare(Fact(ground_texture=input("What's is the ground texture?")))

