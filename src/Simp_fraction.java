public class Simp_fraction {
        public int chisl, znam;
        public Simp_fraction(int chisl, int znam)
        {
            this.chisl = chisl;
            this.znam = znam;
        }
        public Simp_fraction()
        {
            this.chisl = 0;
            this.znam = 1;
        }
        public int getChisl() {
            return chisl;
        }
        public int getZnam() {
            return znam;
        }
        public void setChisl(int chisl) {
            this.chisl = chisl;
        }
        public void setZnam(int znam) {
            this.znam = znam;
        }
        @Override
        public String toString() {
            return "Simple_fraction{"
                    + chisl
                    + " / " + znam
                    + "}";
        }
        public void Reduct()
        {
            int max_memb = 0;
            if (chisl > znam) {
                max_memb = Math.abs(znam);
            }
            else {
                max_memb = Math.abs(chisl);
            }
            for (int i = max_memb; i > 1; i--) {
                if ((chisl % i == 0) & (znam % i == 0)) {
                    chisl = chisl / i;
                    znam = znam / i;
                }
            }
            if (znam < 0) {
                chisl = -1 * chisl;
                znam = Math.abs(znam);
            }
        }
        public Boolean equals(Simp_fraction sec_fr) {
            if (this == sec_fr) return true;
            if (sec_fr == null || getClass() != sec_fr.getClass()) return false;
            this.Reduct();
            sec_fr.Reduct();
            if (this.znam == sec_fr.znam & this.chisl == sec_fr.chisl) {
                return true;
            }
            else {
                return false;
            }
        }
        @Override
        public int hashCode() {
            int result = chisl + znam;
            return result;
        }
        public Simp_fraction sum(Simp_fraction sec_fr) {
            Simp_fraction result_fr = new Simp_fraction();
            result_fr.chisl = (this.chisl * sec_fr.znam + sec_fr.chisl * this.znam);
            result_fr.znam = this.znam * sec_fr.znam;
            result_fr.Reduct();
            return result_fr;
        }
        public Simp_fraction substr(Simp_fraction sec_fr) {
            Simp_fraction result_fr = new Simp_fraction();
            result_fr.chisl = (this.chisl * sec_fr.znam - sec_fr.chisl * this.znam);
            result_fr.znam = this.znam * sec_fr.znam;
            result_fr.Reduct();
            return result_fr;
        }
        public Simp_fraction mult(Simp_fraction sec_fr) {
            Simp_fraction result_fr = new Simp_fraction();
            result_fr.chisl = this.chisl * sec_fr.chisl;
            result_fr.znam = this.znam * sec_fr.znam;
            result_fr.Reduct();
            return result_fr;

        }
        public Simp_fraction div(Simp_fraction sec_fr) {
            Simp_fraction result_fr = new Simp_fraction();
            result_fr.chisl = (this.chisl / sec_fr.chisl);
            result_fr.znam = this.znam / sec_fr.znam;
            result_fr.Reduct();
            return result_fr;
        }
}
