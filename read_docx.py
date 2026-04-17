import zipfile
import xml.etree.ElementTree as ET

def extract_text_from_docx(docx_path):
    with zipfile.ZipFile(docx_path, 'r') as z:
        xml_content = z.read('word/document.xml')
        
    tree = ET.fromstring(xml_content)
    namespaces = {'w': 'http://schemas.openxmlformats.org/wordprocessingml/2006/main'}
    
    paragraphs = []
    for p in tree.findall('.//w:p', namespaces):
        texts = []
        for t in p.findall('.//w:t', namespaces):
            if t.text:
                texts.append(t.text)
        text = "".join(texts)
        if text.strip() or text == "":
            paragraphs.append(text)
            
    return "\n".join(paragraphs)

content = extract_text_from_docx('OOP-Lab03-ObjectOrientedTechniques.docx')
with open('docx_output.txt', 'w', encoding='utf-8') as f:
    f.write(content)
