const c=(e,d,h)=>(d.children&&d.children.forEach(d=>{e?h.checked.push(d.id):h.checked=h.checked.filter(c=>c!==d.id),c(e,d,h)}),h.checked);export{c};
