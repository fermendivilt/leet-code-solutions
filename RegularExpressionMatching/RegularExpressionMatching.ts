function isMatch(s: string, p: string): boolean | string {
    if (!p) {
      return !s;
    }

    const first = s && (s[0] === p[0] || p[0] === '.');

    return p.length >= 2 && p[1] === '*' ? isMatch(s, p.slice(2)) || (first && isMatch(s.slice(1), p)) : first && isMatch(s.slice(1), p.slice(1));
  
};