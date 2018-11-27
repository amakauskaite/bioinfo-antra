# bioinfo-antra
Užduoties aprašymas: https://drive.google.com/file/d/1OMZcVg5yRduGdWTEcAjuUwMlRTDjYxbR/view

## 1. FASTAQ VS FASTA
**FASTAQ formatas.** Įprastai seka koduojama 4 eilutėmis (nors 2 ir 4 punktai gali užimti ir daugiau, dažniausiai laikoma, kad užims po 1 eilutę):

1. Eilutė, prasidedanti '@' ženklu, paskui kurį eina sekos ID bei *neprivalomas* aprašymas
2. Pati seka
3. Eilutė, prasidedanti '+' ženklu, paskui kurį *neprivalomai* eina pirmoje eilutėje rašytas ID ir aprašymas, jei toks buvo
4. [2.] punkte aprašytos sekos narių Phred kokybės svorių seka, kur Phred kokybės svoris įgauną reikšmę nuo 0 iki 93 ir yra koduojamas ASCII simboliu tarp 33 (!) ir 126 (~)
  
  **Kokia papildoma informacija pateikiam lyginant su FASTA formatu?** Papildomai pateikiamas sekos narių kokybės įvertinimas  

## 2. ASCII ir gimtadienis
**Kurią mėnesio dieną Jūs gimėte?** 9

  **Prie dienos pridėkite 33. Koks ASCII simbolis atitinka šį skaičių?** 42 = '*'  

## 3. ASCII simboliai
**Kodėl pirmi 32 ASCII kodai negali būti naudojami sekos kokybei koduoti?** Kadangi pirmi 32 simboliai yra rezervuoti specialioms reikšmėms pvz. CR (carriage return), NULL ir nėra spausdinami į ekraną
